import React from 'react';
import { sharedStyles, portalColors } from './style';

const Portal3 = () => {
  const color = portalColors.phone;
  const listings = [
    { id: 1, title: "iPhone 16 Pro Max", price: "35 Triệu VNĐ", details: "Màu Titan Xanh, phiên bản 1TB, Fullbox. Bảo hành chính hãng Apple." },
    { id: 2, title: "Samsung Galaxy S25 Ultra", price: "30 Triệu VNĐ", details: "12GB RAM, 512GB ROM, Camera 200MP. Tặng kèm bao da và sạc nhanh." },
    { id: 3, title: "Oppo Reno 10 5G", price: "7 Triệu VNĐ", details: "Pin 5000mAh, sạc nhanh 67W. Màn hình AMOLED 120Hz." }
  ];

  return (
    <div style={sharedStyles.container}>
      <h1 style={{ 
        ...sharedStyles.header, 
        color: color, 
        borderBottomColor: color 
      }}>
        PORTAL 3: BÁN ĐIỆN THOẠI 📱
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

export default Portal3;