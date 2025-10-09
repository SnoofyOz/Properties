import React from 'react';
import { sharedStyles, portalColors } from './style'; 

const Portal1 = () => {
  const color = portalColors.car;
  const listings = [
    { id: 1, title: "Toyota Camry 2.5Q 2023", price: "1.1 Tỷ VNĐ", details: "Màu đen, động cơ 2.5L, xe nhập khẩu. ODO 15,000 km, bảo dưỡng định kỳ." },
    { id: 2, title: "Ford Everest Titanium 2024", price: "1.4 Tỷ VNĐ", details: "SUV 7 chỗ mạnh mẽ, động cơ Turbo, nội thất da cao cấp. Bảo hành chính hãng 3 năm." },
    { id: 3, title: "Mazda 3 Luxury Sedan", price: "750 Triệu VNĐ", details: "Thiết kế KODO, full option, cửa sổ trời. Xe đăng ký cuối 2023, còn mới 99%." }
  ];

  return (
    <div style={sharedStyles.container}>
      <h1 style={{ 
        ...sharedStyles.header, 
        color: color, 
        borderBottomColor: color 
      }}>
        PORTAL 1: BÁN XE 🚗
      </h1>
      <div style={sharedStyles.cardGrid}>
        {listings.map(item => (
          <div 
            key={item.id} 
            style={{ 
              ...sharedStyles.card, 
              borderLeftColor: color 
            }}>
            <h2 style={sharedStyles.title}>{item.title}</h2>
            <p style={sharedStyles.price}>{item.price}</p>
            <p style={sharedStyles.details}>{item.details}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Portal1;