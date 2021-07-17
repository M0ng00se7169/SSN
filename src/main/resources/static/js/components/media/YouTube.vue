<template>
    <iframe width="560" height="315" :src="targetSrc" title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen>

    </iframe>
</template>

<script>
    export default {
        name: 'YouTube',
        props: ['src'],
        computed: {
            targetSrc() {
                let parts = this.src.split('/');
                return `https://www.youtube.com/embed/${parts[parts.length - 1]}`
            }
        }
    }
</script>

<style></style>