<template>
  <div class="protected" v-if="loginSuccess">
    <h5>로그인 성공!</h5>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
  <div class="unprotected" v-else-if="loginError">
    <h1>
      <b-badge variant="danger">이 페이지에 대한 접근 권한이 없습니다.</b-badge>
    </h1>
    <h5>로그인 실패!</h5>
  </div>
  <div class="unprotected" v-else>
    <h1>
      <b-badge variant="info">로그인해주세요</b-badge>
    </h1>
    <h5>로그인 하지 않았습니다. 로그인을 해주세요</h5>

    <form @submit.prevent="login()">
      <label>
        <input type="text" placeholder="username" v-model="user">
      </label>
      <label>
        <input type="password" placeholder="password" v-model="password">
      </label>
      <button variant="success" type="submit">Login</button>
      <p v-if="error" class="error">Bad login information</p>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'LogIn',
  components: {
    HelloWorld
  },
  data() {
    return {
      loginSuccess: false,
      loginError: false,
      user: '',
      password: '',
      error: false
    }
  },
  methods: {
    async login() {
      try {
        const result = await axios.get('/login', {
          auth: {
            username: this.user,
            password: this.password
          }
        });
        if (result.status === 200) {
          this.loginSuccess = true
        }
      } catch (err) {
        this.loginError = true;
        throw new Error(err)
      }
    }
  }
}

</script>