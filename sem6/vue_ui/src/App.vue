<template>
  <div id="app">
    <VmHeading type="1" :texte="textea"></VmHeading>
    <VmHeading type="2" :texte="texteb"></VmHeading>
    <VmHeading type="3" :texte="textec"></VmHeading>
    <br /><br />
    <VmButton texte="Mon bouton"></VmButton><br />
    <VmButton texte="Mon bouton outline" outline></VmButton><br />
    <VmButton texte="Mon bouton clear" clear></VmButton>
  </div>
</template>

<script>
import VmHeading from './components/VmHeading';
import VmButton from './components/VmButton';

export default {
  name: 'app',
  data() {
    return {
      textea: 'Mon texte H1',
      texteb: 'Mon texte H2',
      textec: 'Mon texte H3'
    }
  },
  components: {
    VmHeading,
    VmButton
  }
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
