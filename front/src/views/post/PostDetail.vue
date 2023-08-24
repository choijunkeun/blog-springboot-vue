<template>
    <div class="board-detail">
        <div class="board-contents">
            <h3>{{ title }}</h3>
            <h2>나오나요?</h2>
            <div>
                <strong class="w3-large">{{ content }}</strong>
                <br>
                <span>{{ lastModifiedDate }}</span>
            </div>
        </div>
        <div class="board-contents">
            <span>{{ content }}</span>
        </div>
    </div>
</template>

<script>
export default {
    data() { //변수생성
        return {
            requestBody: this.$route.query,
            id: this.$route.query.id,

            title: '',
            content: '',
            lastModifiedDate: '',
        }
    },
    mounted() {
        this.fnGetView()
    },
    methods: {
        fnGetView() {
            this.$axios.get('/api/posts/' + this.id, {
                params: this.requestBody
            }).then((res) => {
                console.log("디테일 들어오나 확인이나 하자");
                console.log(res);
                this.title = res.data.title
                this.content = res.data.content
                this.lastModifiedDate = res.lastModifiedDate
            }).catch((err) => {
                if (err.message.indexOf('Network Error') > -1) {
                    alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
                }
            })
        },



    }
}
</script>

<style>
</style>