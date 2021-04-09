//회원가입/로그인 폼을 보여 줍니다.
import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import palette from '../../lib/styles/palette';
import Button from '../common/Button';

const AuthFormBlock = styled.div `
  h3 {
    margin: 0;
    color: ${palette.gray[8]};
    margin-bottom: 1rem;
  }
`;

// 스타일링된 input
const StyledInput = styled.input`
  font-size: 1rem;
  border: none;
  outline: none;
  border-bottom: 1px solid ${palette.gray[5]};
  padding-bottom: 0.5rem;
  width: 100%;
   
  &:focus {
    color: $oc-teal-7;
    border-bottom: 1px solid ${palette.gray[7]};
  }
  
  & + & {
    margin-top 1rem;  
  }
`;

// 폼 하단에 로그인 혹은 회원가입 링크를 보여줌
const Footer = styled.div`
  margin-top: 2rem;
  text-align: right;
  a {
    color: ${palette.gray[6]};
    text-decoration: underline;
    $:hover{
      color: ${palette.gray[9]};
    }
  }
`;

// Style props를 전달하는 방법 vs 새로운 컴포넌트 정의
// 새로운 컴포넌트르 만드는게 더 가독성이 좋음
const ButtonWithMarginTop = styled(Button)`
  margin-top 1rem;
`;

// type 값에 따라 사용되는 문구와 인풋창이 달라지게 설정
const textMap = {
  login: '로그인',
  register: '회원가입',
};


const AuthForm = ({type, form, onChange, onSubmit}) => {
  const text = textMap[type];
  return (
    <AuthFormBlock>
      <h3>{text}</h3>
      <form onSubmit = {onSubmit}>
        <StyledInput 
          autoComplete = "username" 
          name = "username" 
          placeholder = "아이디" 
          onChange = {onChange}
          value = {form.username}
        />
        <StyledInput 
          autoComplete = "new-password" 
          name = "password" 
          placeholder = "비밀번호" 
          type = "password"
          onChange = {onChange}
          value = {form.password}
        />
        {type === 'register' && (
          <StyledInput
            autoComplete = "new-password"
            name = "passwordConfirm"
            placeholder = "비밀번호 확인"
            type = "password"
            onChange = {onChange}
            value = {form.passwordConfirm}
          />
        )}
        <ButtonWithMarginTop cyan fullWidth>
          {text}
        </ButtonWithMarginTop>
      </form>
      <Footer>
        {type === 'login' ? (
          <Link to = "/register">회원가입</Link>
        ) : (
          <Link to = "/login">로그인</Link>
        )}
      </Footer>
    </AuthFormBlock>
  );
};

export default AuthForm;
