import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Card, Spinner, Alert, Row, Col, ListGroup } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

const UserDetail = () => {
    const { id } = useParams();
    const [user, setUser] = useState(null); 
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetchUserDetail();
    }, [id]);

    const fetchUserDetail = () => {
        const token = localStorage.getItem('token');
        setLoading(true);
        setError(null);

        fetch(`http://localhost:8080/v1/api/admin/users/${id}`, { 
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json',
            },
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Lỗi HTTP: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            setUser(data); 
            setLoading(false);
        })
        .catch(e => {
            console.error("Lỗi khi tải chi tiết người dùng:", e);
            setError(`Không thể tải chi tiết người dùng. ${e.message}`);
            setLoading(false);
            setUser(null);
        });
    };
    
    const formatDate = (dateString) => {
        if (!dateString) return 'Chưa rõ';
        try {
            return new Date(dateString).toLocaleDateString('vi-VN', {
                year: 'numeric', month: 'long', day: 'numeric'
            });
        } catch {
            return dateString;
        }
    };

    if (loading) {
        return (
            <Container className="text-center mt-5">
                <Spinner animation="grow" variant="primary" role="status">
                    <span className="visually-hidden">Đang tải chi tiết người dùng...</span>
                </Spinner>
                <p className="mt-3 text-muted">Đang tải dữ liệu...</p>
            </Container>
        );
    }
    if (error || !user) {
        return (
            <Container className="mt-5">
                <Alert variant={error ? "danger" : "warning"} className="text-center">
                    <h4>{error ? "Lỗi!" : "Không tìm thấy!"}</h4>
                    <p>{error || `Thông tin người dùng có ID: ${id} không khả dụng.`}</p>
                </Alert>
            </Container>
        );
    }
    return (
        <Container className="my-5">
            <h2 className="mb-4 text-center text-primary">Chi tiết Người Dùng</h2>

            <Row className="justify-content-center">
                <Col md={8} lg={6}>
                    <Card className="shadow-lg border-0">
                        <Card.Header as="h4" className="bg-primary text-white py-3 text-center">
                            Chi tiết
                        </Card.Header>

                        <Card.Body>
                            <ListGroup variant="flush">
                                <ListGroup.Item>
                                    <Row>
                                        <Col xs={4} className="fw-bold text-start">Username:</Col>
                                        <Col xs={8} className="text-start">{user.username}</Col>
                                    </Row>
                                </ListGroup.Item>

                                <ListGroup.Item>
                                    <Row>
                                        <Col xs={4} className="fw-bold text-start">ID:</Col>
                                        <Col xs={8} className="text-start text-muted">{user.userId}</Col>
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

export default UserDetail;