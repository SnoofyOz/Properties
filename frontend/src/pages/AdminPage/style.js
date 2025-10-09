// style.js

export const styles = {
    // --- LAYOUT CHÍNH ---
    adminLayout: {
        display: 'flex',
        minHeight: '100vh',
        backgroundColor: '#f8f9fa',
    },

    // --- SIDEBAR ---
    sidebarContainer: {
        width: '220px',
        background: '#222',
        color: '#fff',
        padding: '32px 0',
        boxShadow: '2px 0 5px rgba(0,0,0,0.1)',
        position: 'sticky', // Tùy chọn: Giữ sidebar cố định khi cuộn
        top: 0,
        height: '100vh',
    },
    sidebarHeader: {
        textAlign: 'center',
        marginBottom: 40,
        color: '#ffc107',
    },
    // Hàm trả về style cho mỗi mục (có kiểm tra trạng thái active)
    getSidebarItemStyle: (isSelected) => ({
        padding: '16px 32px',
        cursor: 'pointer',
        display: 'flex',
        alignItems: 'center',
        background: isSelected ? '#444' : 'none',
        fontWeight: isSelected ? 'bold' : 'normal',
        transition: 'background 0.1s',
    }),
    
    // --- CONTENT CHÍNH ---
    contentContainer: {
        padding: '2rem',
        flexGrow: 1,
    },

    // --- BUTTONS (Ví dụ) ---
    actionButton: {
        marginRight: 8,
        padding: '4px 10px',
        border: 'none',
        borderRadius: 4,
        cursor: 'pointer',
        backgroundColor: '#007bff',
        color: 'white',
    },
    actionButtonDanger: {
        padding: '4px 10px',
        border: 'none',
        borderRadius: 4,
        cursor: 'pointer',
        backgroundColor: '#dc3545',
        color: 'white',
    },
};