import React, { useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { FaUsers, FaBuilding, FaGlobe, FaHome } from 'react-icons/fa';
import { styles } from './style'; 

function getRoleFromToken(token) {
  if (!token) return null;
  try {
    const payload = token.split('.')[1];
    const decoded = JSON.parse(atob(payload)); 
    return decoded.role || decoded.authorities?.[0]?.authority || null; 
  } catch (e) {
    return null;
  }
}

const sidebarItems = [
    { key: 'home', name: 'Home', path: '/admin', icon: FaHome },
    { key: 'user', name: 'User', path: '/admin/users', icon: FaUsers },
    { key: 'property', name: 'Property', path: '/admin/properties', icon: FaBuilding },
    { key: 'portal', name: 'Portal', path: '/admin/portals', icon: FaGlobe },
];

const AdminPage = ({ children }) => {
    const navigate = useNavigate();
    const location = useLocation();

    useEffect(() => {
        const token = localStorage.getItem('token');
        const role = getRoleFromToken(token);
        
        if (role !== 'ROLE_SYSTEM_ADMIN') {
            navigate('/');
        }
    }, [navigate]);

    const token = localStorage.getItem('token');
    const role = getRoleFromToken(token);

    if (role !== 'ROLE_SYSTEM_ADMIN') {
        return null;
    }
    return (
        <div style={styles.adminLayout}> 
            <div style={styles.sidebarContainer}>
                <h3 style={styles.sidebarHeader}>Quản lý</h3> 
                {sidebarItems.map(item => {
                    const isSelected = location.pathname === item.path;
                    return (
                        <div
                            key={item.key}
                            style={styles.getSidebarItemStyle(isSelected)}
                            onClick={() => navigate(item.path)}
                        >
                            <item.icon style={{ marginRight: 10 }} />
                            {item.name}
                        </div>
                    );
                })}
            </div>
            <div style={styles.contentWrapper}> 
                {children}
            </div>
        </div>
    );
};

export default AdminPage;