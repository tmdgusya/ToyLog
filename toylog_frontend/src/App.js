import React from 'react';
import { Route } from 'react-router-dom';
import PostListPage from './pages/PostListPage.js';
import LoginPage from './pages/LoginPage.js';
import RegisterPage from './pages/RegisterPage.js';
import WritePage from './pages/WritePage.js';
import PostPage from './pages/PostPage.js';

const App = () => {
  return (
    <>
      <Route component = {PostListPage} path = {['/@:username', '/']} exact />
      <Route component = {LoginPage} path = "/login" />
      <Route component = {RegisterPage} path = "/register" />
      <Route component = {WritePage} path = "/write" />
      <Route component = {PostPage} path = "/@:username/:postId" />
    < />
  );
};
export default App;
