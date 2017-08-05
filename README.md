# opengl04-01
Código base da aula 4 de OpenGL. Nesta aula, veremos como adicionar a camera a cena.

A camera é formada por dois tipos de transformação:
* Transformação de View: Responsável pelo posicionamento da câmera no espaço.
* Transformação de projeção: Que indica a abertura da câmera. 

Para que fornecer esses dados, criaremos um classe da camera e forneceremos essas duas matrizes ao shader.
