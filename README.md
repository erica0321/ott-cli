# 📽️ KCS OTT CLI

<div align="center">
  <img src="https://github.com/erica0321/ott-cli/assets/81230764/a5200261-1a30-4495-80b0-7bf371ae2e2f" style="width: 600px; height: 300px; object-fit: cover; margin: auto; display: block;"/>
</div>

## 프로젝트 소개

- 해당 프로젝트는 Kakao Cloud School in JEJU에서 진행한 프로젝트입니다.
- Java로 만든 OTT 서비스입니다.

## 1. 개발 환경

- Java

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
     │     ├── ActionMovie.java
     │     ├── CrimeDrama.java
     │     ├── Drama.java
     │     ├── Entertainment.java
     │     ├── HistoricalDrama.java
     │     ├── Media.java
     │     ├── Movie.java
     │     ├── RomanticDrama.java
     │     └── SadMovie.java
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
     ├── thread
     │     ├── MediaLoadingThread.java
     │     └── AdThread.java
     └── utils
           ├── AdminActionConstant.java
           ├── PlayerActionConstant.java
           ├── InputUtils.java
           ├── PrintUtils.java
           └── InvalidInputException.java
```


## 3. 개발 기간

- 전체 개발 기간: 2024-05-15 ~ 2024-05-23

## 4. 로직 및 다이어그램 
### 💡 로직
<img src="https://github.com/erica0321/ott-cli/assets/81230764/9dbf20be-3703-4279-8851-634e4811122d" style="width: 800px" />

- 플레이어와 관리자는 가능한 Action에 `로그아웃`, `프로그램 종료`도 가지고 있음
- 로그아웃 시 로그인 화면으로 되돌아감
- 프로그램 종료 시 프로그램 종료
- 모든 인풋을 받는 곳에서 원하지 않은 입력을 받을 시 재 입력 받게 함

**[ 로그인 로직 ]**
- 로그인은 Player, Admin으로 가능
- 로그인 화면에서 고를 수 있게 화면 표출
- 예상 코드 로직
  ```
    public User logIn(type, id, password) {
    	if(player) {
    		id와 password가 같은 유저가 존재 
    		return player
    	} else (admin) {
    		admin의 id와 password가 같은지 확인
    		return admin
    	}
    }
  ```
  
**[ Player 활동 로직 ]**
- Player로 로그인했으면 무엇을 할지 물어봄
    
    (1) 시청하기, (2) 시청기록 보기, (3) 로그아웃, (0) 프로그램 종료
    
- 시청하기일 경우, 미리 저장되어 있던 더미데이터 보여주면서 입력받고 하기
- 시청기록을 선택할 경우, Player의 watched 속성을 보여줌 → 이때 길이가 0일 때 예외 처리

**[ Admin 활동 로직 ]**
- Admin으로 로그인했으면 무엇을 할지 물어봄
    
    (1) 영상 등록하기, (2) 영상 삭제하기, (3) 로그아웃, (0) 프로그램 종료
    
- 영상 등록하기일 경우, 영상 타입을 받아오고, 정보 입력받아 생성자로 생성해서 ArrayList에 저장
- 영상 삭제하기일 경우, 영상 목록 + 인덱스롤 보여주고, 인덱스를 입력받아 해당 영상 삭제

### Media 클래스 
<img src="https://github.com/erica0321/ott-cli/assets/81230764/60714036-6838-4d43-8efb-735d1780058d" style="width: 800px" />

<img src="https://github.com/erica0321/ott-cli/assets/81230764/97e79102-1334-4e1c-a415-3414ba7e8b4f" style="width: 600px" />

- 슈퍼 클래스: Media
    서브 클래스: Entertainment, Drama, Movie
- 슈퍼 클래스: Drama
    서브 클래스:  CrimeDrama, RomanticDrama, HistoricalDrama    
- 슈퍼 클래스: Movie    
    서브 클래스: SadMovie, ActionMovie
  
- Media 클래스 및 하위 클래스

  |클래스 명|속성|메서드|
  |:---|:---|:---|
  |Media|- title: 영상 제목 <br/>- duration: 영상 길이|- toString(): 영상 정보를 문자열로 반환 <br/> - showMediaType(): 영상 타입을 고르고, 해당 타입과 일치하는 영상 목록 반환 <br/> - showMedia(): 영상 목록 속 영상 목록 중 시청할 영상 고르기|
  |Entertainment|- broadCom: 방송사 정보|- toString(): 오버라이딩 -> broadCom 포함해서 반환|
  |Drama|- episodes: 몇 부작 <br/>- rating: 평점|- toString(): 오버라이딩 -> episodes 포함해서 반환|
  |CrimeDrama|- crimeType: 범죄 유형|- toString(): 오버라이딩 -> crimeType 포함해서 반환|
  |RomanticDrama|- actorF: 여자 주인공 <br/>- actorM: 남자 주인공|- toString(): 오버라이딩 -> actorF, actorM 포함해서 반환|
  |HistoricalDrama|- generation: 시대 배경|- toString( ): 오버라이딩 → generation 포함해서 반환|
  |Movie|- view: 관객 수 <br/>- release:  상영 여부|- toString( ): 오버라이딩 → view, release 포함해서 반환|
  |SadMovie|- reason: 슬픈 이유|- toString( ): 오버라이딩 → reason 포함해서 반환|
  |ActionMovie|- film: 영화사|- toString( ): 오버라이딩 → film 포함해서 반환|



### User 클래스
<img src="https://github.com/erica0321/ott-cli/assets/81230764/ccc3de29-35ff-4d52-9865-fbda21c8ba0a" style="width: 400px" />
<img src="https://github.com/erica0321/ott-cli/assets/81230764/2398051c-dd5d-4c0d-a1f7-c17b93c76ee9" style="width: 400px" />

- 슈퍼 클래스: User
  서브 클래스: Player, Admin

- User 클래스 및 하위 클래스

  |클래스 명|속성|메서드|
  |:---|:---|:---|
  |User|- id: 사용자의 id <br/>- password: 사용자 비밀번호|- toString(): 유저 id 문자열로 반환|
  |Player|- watched: 사용자의 영상 시청 기록 리스트|- addWatched: 영상 시청 기록 추가 <br/>- showWatchedList: 사용자의 영상 시청 기록 반환  <br/>- showAction(): 오버라이딩 -> 사용자 액션|
  |Admin|- role: 역할|- showAction(): 오버라이딩 -> 관리자 액션|
  |Actionalble||- showAction: 사용자 혹은 관리자가 하는 행동|


### MediaFactory 인터페이스
<img src="https://github.com/erica0321/ott-cli/assets/81230764/90ce9041-12bd-485f-99c5-bfe59e1fb5b9" style="width: 800px" />

- 디자인 패턴 Factory Method 구현
- 인터페이스: MediaFactory
  클래스: MediaFactoryImpl, EntertainmentFactory, DramaFactory, MovieFactory, CrimeDramaFactory, RomanticDramaFactory, HistoricalDramaFactory, SadMovieFactory, ActionMovieFactory


## 5. 기능

### 🚀 유저 Action
| 영상 시청 | 시청 기록 | 
|:---|:---|
|![ezgif-5-1bc93ce9af](https://github.com/erica0321/ott-cli/assets/81230764/f0f2b507-c838-45ac-bd55-8b8a44dca6f5)|![ezgif-5-b56ab2c2f5](https://github.com/erica0321/ott-cli/assets/81230764/2a55e419-9f41-47c4-94c0-da1ef2bc488f)|

- 로그아웃
- 프로그램 종료

### 🚀 관리자 Action
| 영상 등록 | 영상 삭제 |
|:---|:---|
|![ezgif-5-dab0c330da](https://github.com/erica0321/ott-cli/assets/81230764/a1364d73-59f5-44b4-bae0-13546d319cd7)|![ezgif-5-6bb6edcfdd](https://github.com/erica0321/ott-cli/assets/81230764/5b70655b-4f82-4deb-89f6-48d291d0fcb5)|

- 로그아웃
- 프로그램 종료

### 📢 TODO
- 회원가입
- 실제 영상 url 노출
