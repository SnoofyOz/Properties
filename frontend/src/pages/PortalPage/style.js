// style.js

const sharedStyles = {
  container: {
    padding: '20px',
    maxWidth: '1200px',
    margin: '0 auto',
    fontFamily: 'Roboto, Arial, sans-serif',
    backgroundColor: '#f8f9fa'
  },
  header: {
    fontSize: '28px',
    fontWeight: 'bold',
    borderBottom: '3px solid',
    paddingBottom: '10px',
    marginBottom: '20px',
    display: 'flex',
    alignItems: 'center',
  },
  cardGrid: {
    display: 'grid',
    gridTemplateColumns: 'repeat(auto-fit, minmax(320px, 1fr))',
    gap: '25px',
  },
  card: {
    backgroundColor: '#fff',
    borderRadius: '12px',
    boxShadow: '0 6px 15px rgba(0, 0, 0, 0.1)',
    padding: '25px',
    transition: 'transform 0.3s ease-in-out',
    borderLeft: '5px solid',
    // Hover effect
    ':hover': {
      transform: 'translateY(-5px)',
      boxShadow: '0 8px 20px rgba(0, 0, 0, 0.15)',
    }
  },
  title: {
    fontSize: '22px',
    fontWeight: 'bold',
    marginBottom: '8px',
    color: '#333'
  },
  price: {
    fontSize: '26px',
    fontWeight: 'bolder',
    color: '#e64980', // Màu hồng nổi bật cho giá
    marginBottom: '15px'
  },
  details: {
    fontSize: '15px',
    color: '#666',
    lineHeight: '1.5'
  }
};

const portalColors = {
    car: '#0056b3', // Xanh dương
    house: '#0a9396', // Xanh ngọc
    phone: '#9d0208' // Đỏ đô
};

export { sharedStyles, portalColors };