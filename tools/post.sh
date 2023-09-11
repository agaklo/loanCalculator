echo "post.sh file"

curl -X POST \
   -H 'Content-Type: application/json' \
   -d @$1 \
   localhost:8080/loan/application