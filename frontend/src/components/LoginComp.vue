<template>
    <div class="text-end mx-5" id="header_nav_confirm_off">
        <!-- <button @click="show" class="btn fs-5" style="color: SeaGreen">
            로그인
        </button>
        <LoginModal :visible="loginModal" @close="loginModal = false" />
        <button type="button" class="btn fs-5" style="color: Plum" id="btnsignin" data-bs-toggle="modal" data-bs-target="#signinModal">
            회원가입
        </button> -->
        
    </div>
</template>

<script>
import LoginModal from '@/components/LoginModal.vue';
export default {
    name: "LoginComp",
    components: {
        LoginModal
    },
    data() {
        return {
            loginModal: false
        };
    },
    methods: {
        show() {
            this.loginModal = true;
            console.log(this.loginModal + "==");
        }
    }
}

</script>
