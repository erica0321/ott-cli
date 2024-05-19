# 📽️ KCS OTT CLI

<div align="center">
  <img src="https://github.com/erica0321/ott-cli/assets/81230764/a5200261-1a30-4495-80b0-7bf371ae2e2f" style="width: 600px; height: 300px; object-fit: cover; margin: auto; display: block;"/>
</div>
<br/>

## 프로젝트 소개

- 해당 프로젝트는 Kakao Cloud School in JEJU에서 진행한 프로젝트입니다.
- Java로 만든 OTT 서비스입니다.
  
  <br/>

## 1. 개발 환경

- Java

<br/>

## 2. 프로젝트 구조

```
└── src.main.java.com.ass6
     ├── Main.java
     ├── data
     │     ├── Medias.java
     │     └── Users.java
     ├── user
     │     ├── User.java
     │     ├── Player.java
     │     └── Admin.java
     ├── media
     │     ├── Media.java
     │     ├── Entertainment.java
     │     ├── Drama.java
     │     ├── CrimeDrama.java
     │     ├── RomanticDrama.java
     │     ├── HistoricalDrama.java
     │     ├── Movie.java
     │     ├── SadMovie.java
     │     └── ActionMovie.java
     ├── mediaFactory
     │     ├── MediaFactory.java
     │     ├── MediaFactoryImpl.java
     │     ├── EntertainmentFactory.java
     │     ├── DramaFactory.java
     │     ├── CrimeDramaFactory.java
     │     ├── RomanticDramaFactory.java
     │     ├── HistoricalDramaFactory.java
     │     ├── MovieFactory.java
     │     ├── SadMovieFactory.java
     │     └── ActionMovieFactory.java
     ├── controller
     │     └── MediaController.java
     └── utils
           ├── AdminActionConstant.java
           ├── PlayerActionConstant.java
           ├── InputUtils.java
           ├── PrintUtils.java
           └── InvalidInputException.java
```


## 3. 개발 기간

- 전체 개발 기간: 2024-05-15 ~

<br/>

## 4. 기능

### 🚀 유저 Action
| 영상 시청 | 시청 기록 | 
|:---|:---|
|![ezgif-5-1bc93ce9af](https://github.com/erica0321/ott-cli/assets/81230764/f0f2b507-c838-45ac-bd55-8b8a44dca6f5)|![ezgif-5-b56ab2c2f5](https://github.com/erica0321/ott-cli/assets/81230764/2a55e419-9f41-47c4-94c0-da1ef2bc488f)|

- 로그아웃
- 프로그램 종료

### 🚀 관리자 Action
| 영상 등록 | 영상 삭제|
|:---|:---|
|![ezgif-5-dab0c330da](https://github.com/erica0321/ott-cli/assets/81230764/a1364d73-59f5-44b4-bae0-13546d319cd7)|![ezgif-5-6bb6edcfdd](https://github.com/erica0321/ott-cli/assets/81230764/5b70655b-4f82-4deb-89f6-48d291d0fcb5)|

- 로그아웃
- 프로그램 종료

### 📢 TODO
- 회원가입
- 실제 영상 url 노출
