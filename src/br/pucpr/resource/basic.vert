#version 330

//Matriz de transformação World. Deve ser carregada pelo Java.
uniform mat4 uWorld;

//--> Precisaremos incluir as matrizes de transformação de câmera aqui <--

//Atributos do vértice: posição e cor
//São variáveis de entrada do shader, portanto, devem ser associadas a buffers pelo java
in vec3 aPosition;
in vec3 aColor;

out vec3 vColor;

void main(){
    //Transforma a posição do triangulo coordenadas do modelo para coordenadas do mundo

    gl_Position = uWorld * vec4(aPosition, 1.0); //<-- Precisaremos incluir também as transformações de câmera aqui
    vColor = aColor;
}