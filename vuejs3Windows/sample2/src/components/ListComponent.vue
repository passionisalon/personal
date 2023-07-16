<template>
    <div>

        <div v-for='(pros,index) in blogData' :key="index">
            <!-- {{ index }} -->
            <h4 @click="$router.push('/detail/'+index)">{{pros.title}}</h4>
            <p @click="$router.push('/detail/'+index)">{{pros.content}}</p>
            <p @click="$router.push('/detail/'+index)">{{pros.date}}</p>
            <!-- <p ><router-link to='/detail/'+index>{{ pros.content }}</router-link></p>
            <p ><router-link to="/detail/" >{{pros.date}}</router-link></p> -->
            <hr>
        </div>
        <hr>
        리스트페이지
    </div>

</template>

<script>
export default{
    props:{
        blogData : Array,
    }
}
</script>

<style>
a,p,h4{
    text-decoration-line: none;
    font-display:black;
}
</style>