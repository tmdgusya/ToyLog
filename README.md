# 블로그 프로젝트

## 블로그 기능 (1.0)

- 게시물 작성 / 수정 / 삭제 / 좋아요 / 공유버튼 / 알림
 
- 댓글 작성 / 수정 / 삭제

- 유저 회원가입 / 로그인 / 탈퇴

## 간단 가입

- 이메일 인증

## 로그인을 Oauth (버전 2.0도입)

- Oauth (kakao, git, google, naver)

## 기술 스택

- DB : (MySQL) MariaDB, REDIS

- Front : React, NodeJs
    - React : 17.0.1
    - Node : 14.16.0
    
- Back-End : Spring Boot 
    - JDK 11 (Oracle)
    - Spring : 2.4.4(Stable)

- ORM : JPA
    
- Format : JSON

- Infra : AWS
    - Image Store : S3
    - EC2 : t4g.micro / t3.nano => DB / Spring

## Git

- 기능 구현은 Issue 에 요구사항을 정리한뒤 해당 담당자가 개발한다.
    - Issue Branch 를 생성하여 개발한다.

- [커밋 메세지 작성법](https://djkeh.github.io/articles/How-to-write-a-git-commit-message-kor/)

- 무조건 Review 가 되어야 Merge가 가능하다.

- 브랜치
    - dev
        - issue branch
    - staging(final) 

- Wiki
    - Swagger Api Doc
    - 최대한 상세하게 적는게 좋음
    
## 담당

- back-end : yoo-jae-sik , jsh

- DB : yoo-jae-sik , jsh

- front-end : tjdeh1230

- infra : tjdeh1230


