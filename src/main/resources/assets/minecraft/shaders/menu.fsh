#ifdef GL_ES
precision mediump float;
#endif

#extension GL_OES_standard_derivatives : enable

uniform vec2      resolution;
uniform float     time;


float rand(vec2 n) {
	return fract(cos(dot(n, vec2(16.9898, 10.1414))) * 9758.5453);
}

float noise(vec2 n) {
	const vec2 d = vec2(0, 1);
	vec2 b = floor(n), f = smoothstep(vec2(0.0), vec2(1.0), fract(n));
	return mix(mix(rand(b), rand(b + d.yx), f.x), mix(rand(b + d.xy), rand(b + d.yy), f.x), f.y);
}

float fbm(vec2 n) {
	float total = -0.1, amplitude = 1.3;
	for (int i = 0; i < 10; i++) {
		total += noise(n) * amplitude;
		n += n;
		amplitude *= 0.1;
	}
	return total;
}

void main() {
	const vec3 c1 = vec3(100.0/255.0, 50.0/255.0, 197.0/255.0);
	const vec3 c2 = vec3(-11.0/255.0, 50.0/255.0, 111.4/255.0);
	const vec3 c3 = vec3(0.2 + .19, 0.19, 0.19);
	const vec3 c4 = vec3(6./255.0, 150.0/255.0, 260./255.0);
	const vec3 c5 = vec3(0.6);
	const vec3 c6 = vec3(.3);

	vec2 p = gl_FragCoord.xy * 7.0 / resolution.xx;
	float q = fbm(p - time * 0.2);
	vec2 r = vec2(fbm(p + q + time * 0.0 - p.x - p.y), fbm(p + q - time * 1.0));
	vec3 c = mix(c1, c2, fbm(p + r)) + mix(c3, c4, r.x) - mix(c5, c6, r.y);
	gl_FragColor = vec4(c * cos(0.0 * gl_FragCoord.y / resolution.y), 1.0);
	gl_FragColor.w = 0.5;

}