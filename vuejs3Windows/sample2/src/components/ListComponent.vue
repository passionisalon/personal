<template>
    <div>
        <div v-for='(pros,index) in blogData' :key="index">
            <h4>{{pros.title}}</h4>
            <p>{{ pros.content }}</p>
            <p>{{pros.date}}</p>
        </div>
        <hr>
        <div>
            <h4>{{blogData[0].title}}</h4>
            <p>{{ blogData[0].content }}</p>
            <p>{{blogData[0].date}}</p>
        </div>
        <div>
            <h4>{{blogData[1].title}}</h4>
            <p>{{ blogData[1].content }}</p>
            <p>{{blogData[1].date}}</p>
        </div>
        <div>
            <h4>{{blogData[2].title}}</h4>
            <p>{{ blogData[2].content }}</p>
            <p>{{blogData[2].date}}</p>
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