/** @type {import('next').NextConfig} */
const nextConfig = {
	webpack: (config) => {
		config.watchOptions = {
			poll: 500,
			aggregateTimeout: 300,
		};
		return config;
	},
};

export default nextConfig;
