<template>
    <div class="flex">
        <div class="column">
            {{ formatDate(this.medication.startDate) }}
            <br/>
            {{ this.medication.name }}
        </div>
        <div class="column">
            {{ this.medication.dose }}
        </div>
    </div>
</template>

<script>
    import moment from 'moment';
    export default {
        name: 'Medication',
        props: ['medication'],
        methods: {
            formatDate(date){
                return moment(date).format("DD-MM-YYYY");
            }
        }
    }
</script>

<style>

    .flex {
        font-size: small;
        display: flex;
        text-align: left;
        justify-content: space-between;
    }
</style>