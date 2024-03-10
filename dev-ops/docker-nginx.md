docker run \
--name Nginx \
-d \
-v /Users/yulong/Desktop/BS/yyl/api-gateshield-center/dev-ops/html:/usr/share/nginx/html \
-v /Users/yulong/Desktop/BS/yyl/api-gateshield-center/dev-ops/nginx/nginx.conf:/etc/nginx/nginx.conf \
-p 8090:80 \
nginx