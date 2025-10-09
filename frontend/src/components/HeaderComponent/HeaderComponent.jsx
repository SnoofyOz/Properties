import React from 'react';
import { Navbar, Nav, Container, NavDropdown, Button } from 'react-bootstrap';
import { Link, useNavigate } from 'react-router-dom';
import { headerStyles } from './style';

function getUserDataFromToken(token) {
  if (!token) return { username: null, id: null };
  try {
    const payload = token.split('.')[1];
    const decoded = JSON.parse(atob(payload));

    return {
      username: decoded.sub || null,
      id: decoded.userId || null
    };
  } catch (e) {
    return { username: null, id: null };
  }
}

const Header = () => {
  const token = localStorage.getItem('token');
  const { username, id } = getUserDataFromToken(token);
  const isLoggedIn = !!username;
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem('token');
    navigate('/');
  };

  return (
    <Navbar bg="dark" variant="dark" className="mb-4" style={headerStyles.navbar}>
      <Container className="d-flex align-items-center justify-content-between">
        <Nav>
          <Nav.Link as={Link} to="/" style={headerStyles.homeLink}>
            Home
          </Nav.Link>
        </Nav>

        <Nav>
          {isLoggedIn ? (
            <NavDropdown
              style={headerStyles.userDropdown}
              title={
                <>
                  <i className="bi bi-person-circle me-1"></i>
                  <span>{username}</span>
                </>
              }
              id="user-nav-dropdown"
              align="end"
            >
              <NavDropdown.Item as={Link} to={`/users/${username}`}>
                Thông tin
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item onClick={handleLogout}>
                Đăng xuất
              </NavDropdown.Item>
            </NavDropdown>
          ) : (
            <div className="d-flex align-items-center">
              <Nav.Link as={Link} to="/register" style={headerStyles.navLink} className="me-2">
                Register
              </Nav.Link>
              <Button
                as={Link}
                to="/login"
                variant="light"
                size="sm"
              >
                Login
              </Button>
            </div>
          )}
        </Nav>
      </Container>
    </Navbar>
  );
};

export default Header;