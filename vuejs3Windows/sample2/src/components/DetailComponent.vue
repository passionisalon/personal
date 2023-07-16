<template>

    <div>

        <!-- <h5>디테일페이지</h5> -->
        <div>
            <h4>{{blogData[$route.params.id].title}}</h4>
            <p>{{ blogData[$route.params.id].content }}</p>
            <p>{{blogData[$route.params.id].date}}</p>
            <h4>상세페이지</h4>
            <p>글제목</p>
            <p>글설명~</p>
        </div>

    </div>

</template>

<script>
export default{
    props:{
        blogData : Object,
    }
}
</script>

<style>

</style>