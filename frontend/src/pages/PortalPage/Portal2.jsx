import React from 'react';
import { sharedStyles, portalColors } from './style'; 

const Portal2 = () => {
  const color = portalColors.car;
  const listings = [
    { id: 1, title: "Nhà 1", price: "1$", details: "Apart" },
    { id: 2, title: "Nhà 2", price: "2$", details: "Apart" },
    { id: 3, title: "Nhà 3", price: "3$", details: "Apart" }
  ];

  return (
    <div style={sharedStyles.container}>
      <h1 style={{ 
        ...sharedStyles.header, 
        color: color, 
        borderBottomColor: color 
      }}>
        PORTAL 1: BÁN NHÀ 🚗
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

export default Portal2;