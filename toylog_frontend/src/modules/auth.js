// Ducks 구조로 생성 (ActionType, Action, Reducer)
import { createAction, handleActions } from 'redux-actions';
import produce from 'immer';

// 1. state정의 
const initialState = {
  register: {
    username: '',
    password: '',
    passwordConfirm: '',
  },
  login: {
    username: '',
    password: '',
  },
};

// 2. action type 정의
const CHANGE_FIELD = 'auth/CHANGE_FIELD';
const INITIALIZE_FORM = 'auth/INITIALIZE_FORM';

// 3. action 생성자 정의
export const initializeForm = createAction(INITIALIZE_FORM, form => form); // register / login
export const changeField = createAction(
  CHANGE_FIELD,
  ({ form, key, value }) => ({
    form, // register , login
    key, // username, password, passwordConfirm
    value, // 실제 바꾸려는 값
  }),
);

// 액션타입에 접두사가 붙어있기 때문에 대괄호를 추가해준다
// createAction의 두 번째 파라미터에서 payload 생성 함수를 전달하여 코드상으로 명시
const auth = handleActions(
  {
    [CHANGE_FIELD]: (state, { payload: { form, key, value } }) =>
      produce(state, draft => {
        draft[form][key] = value; // 예: state.register.username을 바꾼다.
      }),
      
    [INITIALIZE_FORM]: (state, { payload: form }) => ({
      ...state,
      [form]: initialState[form],
    }),
  },
  initialState,
);

export default auth;




/*
const reducer = handleActions({
  INCREMENT: (state, action) => ({
    counter: state.counter + action.payload
  }),
 
  DECREMENT: (state, action) => ({
    counter: state.counter - action.payload
  })
}, { counter: 0 });


출처: https://backback.tistory.com/316 [Back Ground]
이것도 한번다시 봐야됨
https://begin-redux.vlpt.us/07-immer.html
*/