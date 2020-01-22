function helloworld() {
  // TODO melhorar esse código
  console.log('Hello World');
}

const saudacao = () => {
  // FIXME resolver isso aqui
  const hora = new Date().getHours();
  if (hora <= 12) return 'Bom dia';
  if (hora <= 18) return 'Boa tarde';
  return 'Boa noite';
// return data.getHours() <= 12 ? 'Bom dia.' : data.getHours() <= 18 ? 'Boa tarde.' : 'Boa noite.';
};
// Executando as funções
// BUG se ligue nas tretas!
helloworld();
console.log(`A saudação do momento é ${saudacao()}`);
