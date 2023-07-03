#version 120
uniform sampler2D textureIn;
void main() {
    vec4 original = texture2D(textureIn, gl_TexCoord[0].st); // �������� ������������ ���� ��������
    float d = (original.r + original.b + original.g) / 3; // ��������� �������
    gl_FragColor = vec4(d, d, d, 1);
}