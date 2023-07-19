<template>
    <div>
        <div v-if="steps == 0">
            <PostComponent v-bind:pros="pros" v-for="(pros, index) in infodata" :key="index">
                {{pros.name}}
            </PostComponent>
        </div>
        <!-- 필터선택페이지 -->
        <div v-if="steps == 1">
            <div class="upload-image" :style="`background-image:url(${UploadImage})`"></div>
            <div class="filters">
                <FilterBoxComponent v-bind:필터="필터" v-bind:UploadImage="UploadImage" v-for="(필터) in filter" :key="필터">
                    <span>{{필터}}</span>
                    <!-- <template v-slot:a>필터</template>
                    <template v-slot:b><span>데이터</span></template> -->
                    <!-- <template v-slot:default="작명"><span>{{ 작명.msg }}</span></template> -->
                </FilterBoxComponent>
                <!-- slot props -->
                <!-- slot을 사용할 때 부모가 자식데이터를 필요한 경우 사용한다. -->
                <!-- 1<slot :자식데이터="자식데이터"> -->
                <!-- 2부모는 <template v-slot="작명">후에{{ 작명.자식데이터}} -->
            </div>
        </div>

        <!-- 글작성페이지 -->
        <div v-if="steps == 2">
            <div class="upload-image" :style="`background-image:url(${UploadImage})`"></div>
            <div class="write">
                <textarea @input="$emit('write',$event.target.value)" class="write-box">write!</textarea>
            </div>
        </div>
        <hr>
    </div>

    <!-- <div>
        <PostComponent v-bind:pros="infodata[0]"/>
        <PostComponent v-bind:pros="infodata[1]"/>
        <PostComponent v-bind:pros="infodata[2]"/>
    </div> -->
</template>

<script>
import PostComponent from './PostComponent.vue';
import FilterBoxComponent from './FilterBoxComponent.vue';
export default {
    data(){
        return{
            filter:
            [ 
                "aden", "_1977", "brannan", "brooklyn", "clarendon", "earlybird", "gingham", "hudson", 
                "inkwell", "kelvin", "lark", "lofi", "maven", "mayfair", "moon", "nashville", "perpetua", 
                "reyes", "rise", "slumber", "stinson", "toaster", "valencia", "walden", "willow", "xpro2"
            ],
        }
    },
    props: {
        infodata: Object,
        steps: Number,
        UploadImage:String,
    },
    components: {
        PostComponent: PostComponent,
        FilterBoxComponent : FilterBoxComponent,
    }
}
</script>

<style>
.upload-image {
    width: 100%;
    height: 450px;
    background: cornflowerblue;
    background-size: cover;
}

.filters {
    overflow-x: scroll;
    white-space: nowrap;
}

.filter-1 {
    width: 100px;
    height: 100px;
    background-color: cornflowerblue;
    margin: 10px 10px 10px auto;
    padding: 8px;
    display: inline-block;
    color: white;
    background-size: cover;
}

.filters::-webkit-scrollbar {
    height: 5px;
}

.filters::-webkit-scrollbar-track {
    background: #f1f1f1;
}

.filters::-webkit-scrollbar-thumb {
    background: #888;
    border-radius: 5px;
}

.filters::-webkit-scrollbar-thumb:hover {
    background: #555;
}

.write-box {
    border: none;
    width: 90%;
    height: 100px;
    padding: 15px;
    margin: auto;
    display: block;
    outline: none;
}
</style>