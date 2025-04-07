/** @type {import('next').NextConfig} */
const nextConfig = {
  images: {
    unoptimized: true,
    remotePatterns: [
      {
        protocol: 'https',
        hostname: 'ext.same-assets.com',
      },
      {
        protocol: 'http',
        hostname: 'localhost',
      },
      {
        protocol: 'http',
        hostname: 'gateway',
      },
    ],
    domains: ['localhost', 'gateway'],
  },
  typescript: {
    ignoreBuildErrors: true,
  },
  eslint: {
    ignoreDuringBuilds: true,
  },
  async rewrites() {
    // Check if we're running in Docker
    const isDocker = process.env.NEXT_PUBLIC_API_URL && process.env.NEXT_PUBLIC_API_URL.includes('gateway');
    
    return [
      {
        source: '/api/images/:path*',
        destination: isDocker 
          ? 'http://gateway:8078/api/images/:path*' 
          : 'http://localhost:8078/api/images/:path*',
      },
      {
        source: '/api/:path*',
        destination: isDocker 
          ? 'http://gateway:8078/api/:path*' 
          : 'http://localhost:8078/api/:path*',
      }
    ];
  }
};

module.exports = nextConfig;
