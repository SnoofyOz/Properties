export const homeStyles = {
    // Không cần dùng portalListContainer nữa vì đã dùng Row/Col
    // Nếu vẫn cần giữ, đảm bảo nó không phá vỡ Bootstrap Grid
    // portalListContainer: {
    //    display: 'flex', 
    //    flexWrap: 'wrap', 
    //    justifyContent: 'center'
    // },

    // XÓA thuộc tính width cố định, Bootstrap sẽ quản lý nó
    // portalCard: {
    //     width: '300px', // Ví dụ: thuộc tính này sẽ bị loại bỏ
    //     margin: '0 15px'
    // },
    
    // Giữ lại các style khác (như font-size, màu sắc)
    portalTitle: {
        fontSize: '1.4rem',
        fontWeight: '700'
    },
    // ...
};