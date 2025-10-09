import React from 'react';
import { Container, Card, Row, Col } from 'react-bootstrap'; 
import { useNavigate } from 'react-router-dom'; 
import { homeStyles } from './style'; 

const Home = () => {
    const navigate = useNavigate();
    
    const portals = [
        { 
            title: 'Portal 1', 
            desc: 'Xây dựng các ứng dụng web và di động hiệu suất cao theo yêu cầu của bạn.',
            path: '/portal1'
        },
        { 
            title: 'Portal 2', 
            desc: 'Lên chiến lược và thực hiện các giải pháp chuyển đổi số cho doanh nghiệp.',
            path: '/portal2' 
        },
        { 
            title: 'Portal 3', 
            desc: 'Đội ngũ kỹ thuật viên luôn sẵn sàng hỗ trợ bạn bất cứ lúc nào.',
            path: '/portal3' 
        },
        { 
            title: 'SystemAdmin', 
            desc: 'Quản lý tài khoản, phân quyền và cấu hình hệ thống.',
            path: '/account-management' 
        },
    ];

    const handlePortalClick = (path) => {
        if (path) {
            navigate(path);
        }
    };

    return (
        <>
            <Container className="my-5 text-center">
                <h2 className="text-primary mb-5">Cổng dịch vụ</h2> 
                <Row className="justify-content-center"> 
                    {portals.map((portal, index) => (
                        <Col key={index} lg={6} md={8} xs={12}>
                            <Card 
                                className="shadow-lg mb-4" 
                                style={{ 
                                    cursor: 'pointer',
                                    transition: 'transform 0.2s, box-shadow 0.2s',
                                    textAlign: 'left'
                                }}
                                onClick={() => handlePortalClick(portal.path)}
                            >
                                <Card.Body>
                                    <div> 
                                        <Card.Title style={homeStyles.portalTitle} className="text-dark">
                                            <i className="bi bi-box-arrow-in-right me-2"></i> {portal.title}
                                        </Card.Title>
                                        <Card.Text className="text-muted mt-3">
                                            {portal.desc}
                                        </Card.Text>
                                    </div>
                                </Card.Body>
                            </Card>
                        </Col>
                    ))}
                </Row>
            </Container>
        </>
    );
};

export default Home;