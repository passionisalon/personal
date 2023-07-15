<template>
    <div>
        <h5>디테일페이지</h5>
        <div>
            <h4>{{pros.title}}</h4>
            <p>{{ pros.content }}</p>
            <p>{{pros.date}}</p>
        </div>

    </div>

</template>

<script>
export default{
    props:{
        pros : Object,
    }
}
</script>

<style>

</style>