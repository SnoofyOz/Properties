import { Button } from "antd";
import React from "react";

const ButtonComponent = ({ size, styleButton, styleTextButon, textButton, ...rest }) => {
    return (
        <Button
            size={size}
            style={{ borderRadius: 0, ...styleButton }}
            {...rest}
        >
            <span style={styleTextButon}>{textButton}</span>
        </Button>
    )
}

export default ButtonComponent;