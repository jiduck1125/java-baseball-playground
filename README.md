## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

---
## 기능 목록
- 1 ~ 9까지의 숫자로 이루어진 임의의 숫자 3개를 선택
- 유저의 숫자와 컴퓨터의 숫자를 비교해서 결과를 반환
  - 스트라이크인지 확인 (자리와 숫자가 모두 일치)
  - 볼인지 확인 (자리는 다르고 숫자만 일치)
  - 낫싱인지 확인 (자리도 다르고 숫자도 다름)
- 실행 결과에 따라 게임이 종료되었는지 확인
- 유저에게 입력받는 기능
- 결과 또는 메시지를 출력하는 기능