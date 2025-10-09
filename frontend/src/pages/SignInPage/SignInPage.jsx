import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { WrapperContainerLeft, WrapperContainerRight, WrapperTextLight } from './style'
import InputForm from '../../components/InputForm/InputForm'
import ButtonComponent from '../../components/ButtonComponent/ButtonComponent';
import logoLogin from '../../assets/images/Logo-Login.png'
import { Image } from 'antd';
import { EyeFilled, EyeInvisibleFilled } from '@ant-design/icons';

const SignInPage = () => {
  const [isShowPassword, setIsShowPassword] = useState(false)
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const navigate = useNavigate()

    const handleNavigateSignUp = () => {
    navigate('/register')
  }

  const handleLogin = async () => {
    try {
      const response = await fetch('http://localhost:8080/v1/api/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
      })
      const data = await response.json()
      if (data.token) {
        localStorage.setItem('token', data.token)
        const payload = data.token.split('.')[1]
        const decoded = JSON.parse(atob(payload))
        if (decoded.role === 'ROLE_SYSTEM_ADMIN') {
          navigate('/admin')
        } else {
          navigate('/')
        }
      }
    } catch (error) {
      console.error('Login error:', error)
    }
  }

  return (
    <div style={{ background: 'rgba(0, 0, 0, 0.53', display: 'flex', alignItems: 'center', justifyContent: 'center', height: '100vh' }}>
      <div style={{ width: '800px', height: '445px', borderRadius: '10px', background: '#efefef', display: 'flex' }}>
        <WrapperContainerLeft>
          <h1>Hello</h1>
          <p>Login or Register</p>
          <InputForm
            style={{ marginBottom: '10px' }}
            placeholder='username'
            value={username}
            onChange={e => setUsername(e.target.value)}
          />
          <div style={{ position: 'relative' }}>
            <span
              style={{
                zIndex: 10,
                position: 'absolute',
                top: '50%',
                right: '8px',
                transform: 'translateY(-50%)',
                cursor: 'pointer'
              }}
              onClick={() => setIsShowPassword(!isShowPassword)}
            >
              {isShowPassword ? (
                <EyeFilled />
              ) : (
                <EyeInvisibleFilled />
              )}
            </span>
            <InputForm
              placeholder='password'
              type={isShowPassword ? "text" : "password"}
              value={password}
              onChange={e => setPassword(e.target.value)}
            />
          </div>
          <ButtonComponent
            size={20}
            styleButton={{
              margin: '26px 0 10px',
              background: 'rgb(255, 57, 69)',
              width: '100%',
              height: '48px',
              border: 'none'
            }}
            textButton={'Đăng Nhập'}
            styleTextButon={{ color: '#ffff', fontSize: '15px', fontWeight: '600' }}
            onClick={handleLogin}
          >
          </ButtonComponent>
          <WrapperTextLight style={{cursor: 'pointer'}}>Quên mật khẩu?</WrapperTextLight>
          <p onClick={handleNavigateSignUp} style={{cursor: 'pointer'}}>Chưa có tài khoản? <WrapperTextLight> Tạo tài khoản</WrapperTextLight></p>
        </WrapperContainerLeft>

      </div>
    </div>
  )
}

export default SignInPage