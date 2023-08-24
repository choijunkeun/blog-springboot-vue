<template>
    <div>
            <b-card-group deck>
                <b-card
                    v-for="row in list"
                    img-src="https://picsum.photos/600/300/?image=25"
                    img-alt="Image"
                    img-top
                    tag="article"
                    style="max-width: 20rem;"
                    class="mb-3">
                    <b-card-header> {{row.title}} </b-card-header>
                    <b-card-body>
                        <b-button href="javascript:;" @click="fnView(`${row.id}`)" variant="primary">상세보기</b-button>
                    </b-card-body>
                    <b-card-footer>
                        {{row.lastModifiedDate}}
                    </b-card-footer>
                </b-card>
            </b-card-group>
    </div>

</template>

<script>
export default {
    data() { //변수생성
        return {
            requestBody: {}, //리스트 페이지 데이터전송
            list: {}, //리스트 데이터
            no: '', //게시판 숫자처리
            paging: {
                block: 0,
                end_page: 0,
                next_block: 0,
                page: 0,
                page_size: 0,
                prev_block: 0,
                start_index: 0,
                start_page: 0,
                total_block_cnt: 0,
                total_list_cnt: 0,
                total_page_cnt: 0,
            }, //페이징 데이터
            page: this.$route.query.page ? this.$route.query.page : 0,
            size: this.$route.query.size ? this.$route.query.size : 10,
            keyword: this.$route.query.keyword,
            paginavigation: function () { //페이징 처리 for문 커스텀
                let pageNumber = [] //;
                let start_page = this.paging.start_page;
                let end_page = this.paging.end_page;
                for (let i = start_page; i <= end_page; i++) pageNumber.push(i);
                return pageNumber;
            },
        }
    },
    mounted() {
        this.fnGetList()
    },
    methods: {
        fnGetList() {
            this.requestBody = {
                page: this.page,
                size: this.size
            }

            this.$axios.get("/api/posts", {
                params : this.requestBody,
                headers: {}
            }).then((res) => {
                this.list = res.data.content;
                console.log(this.list);
                console.log(res);
            }).catch((err) => {
                if (err.message.indexOf("Network Error") > -1) {
                    alert("잠시후 다시 시도해주세요. 네트워크 이슈..");
                }
            })
        },
        fnView(id) {
            this.requestBody.id = id;
            this.$router.push({
                name: 'postDetail',
                query: this.requestBody
            })
        },

    }
}
</script>