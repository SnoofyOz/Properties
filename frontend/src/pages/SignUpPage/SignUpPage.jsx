import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom' // Cần import để chuyển hướng
import { WrapperContainerLeft, WrapperContainerRight, WrapperTextLight } from './style'
import InputForm from '../../components/InputForm/InputForm'
import ButtonComponent from '../../components/ButtonComponent/ButtonComponent';
import { EyeFilled, EyeInvisibleFilled } from '@ant-design/icons';

const SignUpPage = () => {
  const [isShowPassword, setIsShowPassword] = useState(false)
  const [isShowConfirmPassword, setIsShowConfirmPassword] = useState(false)
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [confirmPassword, setConfirmPassword] = useState('')
  const navigate = useNavigate()
  const handleSignUp = async () => {
    if (password !== confirmPassword) {
      alert('Mật khẩu và xác nhận mật khẩu không khớp.')
      return
    }

    try {
      const response = await fetch('http://localhost:8080/v1/api/users', { 
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
      })

      const data = await response.json()

      if (response.ok && data.id) { 
        alert('Đăng ký thành công! Vui lòng đăng nhập.')
        navigate('/login')
      } else {
        alert(`Đăng ký thất bại: ${data.message || 'Lỗi không xác định'}`)
      }
    } catch (error) {
      console.error('Registration error:', error)
      alert('Đã xảy ra lỗi trong quá trình đăng ký.')
    }
  }

  const handleNavigateSignIn = () => {
    navigate('/login')
  }

  return (
    <div style={{ background: 'rgba(0, 0, 0, 0.53', display: 'flex', alignItems: 'center', justifyContent: 'center', height: '100vh' }}>
      <div style={{ width: '800px', height: '445px', borderRadius: '10px', background: '#efefef', display: 'flex' }}>
        <WrapperContainerLeft>
          <h1>Xin chào</h1>
          <p>Tạo tài khoản mới</p>
          
          {/* Input Username */}
          <InputForm
            style={{ marginBottom: '10px' }}
            placeholder='Tên đăng nhập (Username)'
            value={username}
            onChange={e => setUsername(e.target.value)}
          />

          <div style={{ position: 'relative', marginBottom: '10px' }}>
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
              placeholder="Mật khẩu"
              type={isShowPassword ? "text" : "password"}
              value={password}
              onChange={e => setPassword(e.target.value)}
            />
          </div>
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
              onClick={() => setIsShowConfirmPassword(!isShowConfirmPassword)} 
            >
              {isShowConfirmPassword ? (
                <EyeFilled />
              ) : (
                <EyeInvisibleFilled />
              )}
            </span>
            <InputForm
              placeholder="Nhập lại mật khẩu"
              type={isShowConfirmPassword ? "text" : "password"}
              value={confirmPassword}
              onChange={e => setConfirmPassword(e.target.value)}
            />
          </div>
          <ButtonComponent
            size={20}
            styleButton={{
              margin: '26px 0 10px',
              background: 'rgb(255, 57, 69)',
              width: '100%',
              height: '48px',
              border: 'none',
              opacity: (username && password && confirmPassword) ? 1 : 0.6
            }}
            textButton={'Đăng Kí'}
            styleTextButon={{ color: '#ffff', fontSize: '15px', fontWeight: '600' }}
            onClick={handleSignUp}
            disabled={!(username && password && confirmPassword)}
          >
          </ButtonComponent>
          <p>Đã có tài khoản? 
            <WrapperTextLight onClick={handleNavigateSignIn} style={{ cursor: 'pointer' }}> 
              {' '}Đăng Nhập
            </WrapperTextLight>
          </p>
        </WrapperContainerLeft>
      </div>
    </div>
  )
}

export default SignUpPage