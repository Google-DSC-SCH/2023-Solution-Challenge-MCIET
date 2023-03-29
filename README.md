# MCIET, Mom can I eat this?

<img alt="image" src="">

2023-MCIET-SolutionChallenge-android

---

## Contents
- [MCIET의 의미](#MCIET의_의미)
- [UN의_지속_가능한_개발_목표](#UN의_지속_가능한_개발_목표)
- [기술_스택](#기술_스택)`
- [주요_기능](#주요_기능)
- [API_명세서](#API_명세서)
- [협업자](#협업자)

---

## MCIET의_의미

---

 우리는 평소 냉장고에 못보던 식료품이 있으면, 어머니께 묻곤 합니다. 엄마 이거 먹어도 돼요?

 우리는 항상 냉장고에 있는 식료품을 먹기 위해 꺼내지 않는 이상 식료품의 유통기한이 얼마나 남았는지, 얼마나 냉장고에 오래 있었는지 궁금해하지 않습니다. 따라서 유통기한을 미리 확인하지 못해 못먹고 버려지는 음식도 많습니다. 우리는 이러한 문제를 해결하기 원했고, 우리가 모르는 유통기한을 확인해주는 MCIET(Mom Can I Eat This?)라는 이름의 앱을 만들게 되었습니다.

---

## UN의_지속_가능한_개발_목표

---

<img alt="image" src="">

UN은 인류의 보편적, 지구 환경 , 경제 사회 문제 등등 다양한 17가지 주 목표를 제시하고 있습니다.

### 우리가 달성할 목표

<img alt="image" src="">

#### 목표 3: 건강 및 웰빙

!왜 목표 3이 이뤄졌는지 작성하세요!

<img alt="image" src="">

#### 목표 12: 책임감있는 소비 및 생산

!왜 목표 3이 이뤄졌는지 작성하세요!

---

## 기술_스택

---

- App
  - Flutter
  - Android
- Design
  - 어도비 Illustrator
  - Photoshop
- BE
  - Spring
  - JPA
  - Maria DB
  - FireBase
- ML
  - Tensorflow
  - Keras
  - Tensorflow-Lite

---

## 주요_기능

---

<img alt="image" src="">

### 냉장고 식재료 리스트 보기

<img alt="image" src="">

### 식재료 데이터 추가

<img alt="image" src="">

### 메모 기능

<img alt="image" src="">

---

## API_명세서

---

### Item 3.39.32.28:8080/item/add

- 재료 저장
- method : **POST**
- Request
  - formData
    - key : multipartFile
    - value :
      - 사진 :: Multipart (사용자 사진)
    - key : addItemDto
    - value :
      - name :: String (재료 이름)
      - expirationDate :: String (유통기한)
      - itemCategory :: String (카테고리)
- Response
  - Body
    - success : boolean (성공 여부)
    - status : int (상태)
    - data :
      - itemId :: Long (재료 id)
    - successResponseMessage : String (상태 메세지)
    - timeStamp : String (시간)
  
### 요청 예시

<img alt="image" src="">

### 응답 예시

```json
{
    "success": true,
    "status": 200,
    "data": 3,
    "successResponseMessage": "아이템 저장 완료",
    "timeStamp": "2023-03-25T05:48:27.356019"
}
```

## 3.39.32.28:8080/item/list

- 재료 전체 리스트 보여주기
- method : Get
- Request
  - Body
    - 없음
- Response
  - Body
    - success : boolean 성공 여부
    - status : int 상태
    - `data` :
      - name :: String (재료 이름)
      - expirationDate :: String (재료 유통기한)
      - remainExpirationDate :: int (재료 남은 유통기한)
      - itemCategory :: String (재료 카테고리)
    - successResponseMessage : String 상태 메세지
    - timeStamp : String 시간

### 응답 예시

```json
{
    "success": true,
    "status": 200,
    "data": [
        {
            "name": "tomato",
            "expirationDate": "2023-03-26",
            "remainExpirationDate": 1,
            "itemCategory": "ETC"
        },
        {
            "name": "apple",
            "expirationDate": "2023-03-26",
            "remainExpirationDate": 1,
            "itemCategory": "VEGETABLEANDFRUIT"
        },
        {
            "name": "orange",
            "expirationDate": "2023-03-26",
            "remainExpirationDate": 1,
            "itemCategory": "VEGETABLEANDFRUIT"
        }
    ],
    "successResponseMessage": "아이템 리스트 조회 완료",
    "timeStamp": "2023-03-25T05:48:34.895257"
}
```

## 3.39.32.28:8080/item/{itemId}

- 재료 세부사항 보여주기
- method : Get
- Request
  - Body
    - 없음
- Response
  - Body
    - success : boolean 성공 여부
    - status : int 상태
    - `data` :
      - name :: String (재료 이름)
      - expirationDate :: String (재료 유통기한)
      - filePath :: String (재료 사진 url)
      - remainExpirationDate :: int (재료 남은 유통기한)
      - itemCategory :: String (재료 카테고리)
    - successResponseMessage : String 상태 메세지
    - timeStamp : String 시간

### 응답 예시

```json
{
    "success": true,
    "status": 200,
    "data": {
        "name": "orange",
        "expirationDate": "2023-03-26",
        "filePath": "https://mciet-bucket.s3.ap-northeast-2.amazonaws.com/2572965d-cb99-4729-a067-7149b2972870.png",
        "remainExpirationDate": 1,
        "itemCategory": "VEGETABLEANDFRUIT"
    },
    "successResponseMessage": "아이템 세부사항 조회 완료",
    "timeStamp": "2023-03-25T05:49:57.410041"
}
```

## 3.39.32.28:8080/item/{itemId}

- 재료 삭제하기
- method : Delete
- Request
  - Body
    - 없음
- Response
  - Body
    - success : boolean 성공 여부
    - status : int 상태
    - `data` : null
    - successResponseMessage : String 상태 메세지
    - timeStamp : String 시간
  
### 응답 예시

```json
{
    "success": true,
    "status": 200,
    "data": null,
    "successResponseMessage": "아이템 삭제 완료",
    "timeStamp": "2023-03-25T05:53:32.791026"
}
```

## 3.39.32.28:8080/item/1day/list

- 유통기한 1일 남은 재료들 보여주기
- method : Get
- Request
  - Body
    - 없음
- Response
  - Body
    - success : boolean 성공 여부
    - status : int 상태
    - `data` :
      - name :: String (재료 이름)
    - successResponseMessage : String 상태 메세지
    - timeStamp : String 시간

### 응답 예시

```json
{
    "success": true,
    "status": 200,
    "data": [
        {
            "name": "tomato"
        },
        {
            "name": "apple"
        },
        {
            "name": "orange"
        }
    ],
    "successResponseMessage": "유통기한 1일 남은 재료 조회 완료",
    "timeStamp": "2023-03-25T05:50:47.934013"
}
```

---

## 협업자

---

<table>
  <tr>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/62877861?v=4" width="100px;" alt=""/><br /><b>In Gyu Lee</b><br/>🇰🇷</td>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/62877861?v=4" width="100px;" alt=""/><br /><b>In Gyu Lee</b><br/>🇰🇷</td>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/62877861?v=4" width="100px;" alt=""/><br /><b>In Gyu Lee</b><br/>🇰🇷</td>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/62877861?v=4" width="100px;" alt=""/><br /><b>In Gyu Lee</b><br/>🇰🇷</td>
  <tr>
<table>
