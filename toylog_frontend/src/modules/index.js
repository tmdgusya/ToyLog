import { combineReducers } from 'redux';
import auth from './auth';

// reducer 생성
const rootReducer = combineReducers({
  auth,
});

export default rootReducer;