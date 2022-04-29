# language: pt

Funcionalidade: Comprar Produto
    # Fluxo de compras no site petz
    # Envolve as páginas: Home, Resultado da Consulta e Detalhes do Produto

    Cenario: Compra a partir de uma Busca
      Dado que acesso o site Petz
      Quando busco por "coleira" E pressiono Enter
      Entao e exibido um grid de produtos com "coleira"
      Quando escolho "Coleira Petz Borboletas Coloridas para Cães"
      Entao exibe para o "Tamanho PP" o preco de "R$ 29,99"