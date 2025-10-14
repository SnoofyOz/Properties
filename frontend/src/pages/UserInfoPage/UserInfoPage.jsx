import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Card, Spinner, Alert, Row, Col, ListGroup } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';


const UserInfoPage = () => {
    const { username } = useParams();
    const [user, setUser] = useState(null); 
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetchUserDetail();
    }, [username]);

    const fetchUserDetail = () => {
        const token = localStorage.getItem('token');
        setLoading(true);
        setError(null);

        fetch(`http://localhost:8080/v1/api/users/${username}`, { 
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json',
            },
        })
        .then(response => {
            if (!response.ok) {
                // Ném lỗi nếu response status không phải 2xx
                throw new Error(`Lỗi HTTP: ${response.status} - ${response.statusText}`);
            }
            return response.json();
        })
        .then(data => {
            setUser(data); 
            setLoading(false);
        })
        .catch(e => {
            console.error("Lỗi khi tải chi tiết người dùng:", e);
            setError(`Không thể tải chi tiết người dùng. Vui lòng kiểm tra kết nối hoặc quyền truy cập. Chi tiết: ${e.message}`);
            setLoading(false);
            setUser(null);
        });
    };

    if (loading) {
        return (
            <Container className="text-center mt-5">
                <Spinner animation="grow" variant="primary" role="status">
                    <span className="visually-hidden">Đang tải chi tiết người dùng...</span>
                </Spinner>
                <p className="mt-3 text-muted">Đang tải dữ liệu người dùng có Username: {username}...</p>
            </Container>
        );
    }

    if (error || !user) {
        return (
            <Container className="mt-5">
                <Alert variant={error ? "danger" : "warning"} className="text-center">
                    <h4>{error ? "Lỗi!" : "Không tìm thấy!"} 😥</h4>
                    <p>{error || `Không tìm thấy thông tin người dùng có Username: ${username}.`}</p>
                </Alert>
            </Container>
        );
    }
    return (
        <Container className="my-5">
            <h2 className="mb-4 text-center text-primary">Chi tiết Người Dùng</h2>

            <Row className="justify-content-center">
                <Col md={8} lg={7}>
                    <Card className="shadow-lg border-0">
                        <Card.Header as="h4" className="bg-primary text-white py-3 text-center">
                            Thông tin Cá nhân
                        </Card.Header>

                        <Card.Body>
                            <ListGroup variant="flush">
                                <ListGroup.Item>
                                    <Row>
                                        <Col xs={4} className="fw-bold text-start">UserID:</Col>
                                        <Col xs={8} className="text-start text-muted">{user.userId}</Col>
                                    </Row>
                                </ListGroup.Item>
                                <ListGroup.Item>
                                    <Row>
                                        <Col xs={4} className="fw-bold text-start">Username:</Col>
                                        <Col xs={8} className="text-start text-primary">{user.username}</Col>
                                    </Row>
                                </ListGroup.Item>
                                <ListGroup.Item>
                                    <Row>
                                        <Col xs={4} className="fw-bold text-start">Property:</Col>
                                        <Col xs={8} className="text-start">{user.fullName || 'Chưa cập nhật'}</Col>
                                    </Row>
                                </ListGroup.Item>
                                <ListGroup.Item>
                                    <Row>
                                        <Col xs={4} className="fw-bold text-start">Portal:</Col>
                                        <Col xs={8} className="text-start">{user.fullName || 'Chưa cập nhật'}</Col>
                                    </Row>
                                </ListGroup.Item>
                            </ListGroup>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
};

export default UserInfoPage;