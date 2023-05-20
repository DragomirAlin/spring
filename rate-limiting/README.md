# Rate limiting

Rate limiting is a strategy to limit access to APIs. It restricts the number of API calls that a client can make within a certain time frame. This helps defend the API against overuse, both unintentional and malicious.

As API developers, we have several options when a client reaches the limit:

* Queueing the request until the remaining time period has elapsed
* Allowing the request immediately, but charging extra for this request
* Rejecting the request (HTTP 429 Too Many Requests)

## Rate limiting algorithms
- Token bucket
- Leaking bucket
- Fixed window counter
- Sliding window log
- Sliding window counter



### 1. Token bucket
The Token Bucket algorithm is a popular rate limiting algorithm. It operates based on a bucket that holds a limited number of tokens. Tokens are replenished at a fixed rate, and each incoming request requires a certain number of tokens. If there are enough tokens available, the request is processed, and the corresponding number of tokens is consumed. If there are insufficient tokens, the request is either rejected or delayed until tokens become available.

### 2. Leaking Bucket:
The Leaking Bucket algorithm is another rate limiting algorithm that controls the rate at which requests are processed. It works by imagining a bucket that has a leak at the bottom. Requests are added to the bucket, and they start to leak out at a fixed rate. If the bucket overflows, meaning that the incoming requests exceed the rate at which they can be processed, they are either dropped or delayed. This algorithm provides a constant output rate but can have bursts of requests if they arrive faster than they are leaked.

### 3. Fixed Window Counter:
The Fixed Window Counter algorithm divides time into fixed intervals or windows, such as one second or one minute. It maintains a counter for each window, keeping track of the number of requests received within that window. If the number of requests exceeds a predefined limit for a particular window, subsequent requests are rejected or delayed until the next window starts. This algorithm is simple but can suffer from uneven distribution of requests within each window.

### 4. Sliding Window Log:
The Sliding Window Log algorithm is an improvement over the Fixed Window Counter algorithm. Instead of maintaining counters for fixed windows, it maintains a log of incoming requests with timestamps. When a request arrives, the algorithm checks the log to determine the number of requests within a sliding time window. If the count exceeds the limit, the request is rejected or delayed. This algorithm offers a more granular rate limiting mechanism and handles unevenly distributed requests better than the Fixed Window Counter algorithm.

### 5. Sliding Window Counter:
The Sliding Window Counter algorithm is similar to the Sliding Window Log algorithm but uses a fixed-size circular buffer instead of a log. The buffer is divided into intervals, and each interval represents a fixed time period. The algorithm maintains a counter for each interval, tracking the number of requests received within that interval. As time progresses, older intervals are discarded, and new intervals are added. This algorithm provides a sliding time window rate limiting mechanism while using a fixed-size buffer, which makes it more efficient than the Sliding Window Log algorithm.

