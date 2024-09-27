# Performance Results

## N = 100

| Threads | Run 1 | Run 2 | Run 3 | Average Time |
|---------|-------|-------|-------|--------------|
| 1       | 3ms   | 0ms   | 1ms   | 1ms          |
| 2       | 1ms   | 1ms   | 1ms   | 1ms          |
| 4       | 1ms   | 0ms   | 1ms   | 0ms          |
| 8       | 2ms   | 8ms   | 2ms   | 4ms          |
| 16      | 3ms   | 2ms   | 3ms   | 2ms          |
| 32      | 6ms   | 6ms   | 6ms   | 6ms          |
| 64      | 17ms  | 18ms  | 14ms  | 16ms         |
| 128     | 23ms  | 22ms  | 36ms  | 27ms         |
| 256     | 65ms  | 81ms  | 90ms  | 78ms         |
| 512     | 130ms | 254ms | 186ms | 190ms        |

## N = 1000

| Threads | Run 1 | Run 2 | Run 3 | Average Time |
|---------|-------|-------|-------|--------------|
| 1       | 10ms  | 1ms   | 1ms   | 4ms          |
| 2       | 1ms   | 1ms   | 1ms   | 1ms          |
| 4       | 3ms   | 3ms   | 3ms   | 3ms          |
| 8       | 3ms   | 6ms   | 6ms   | 5ms          |
| 16      | 7ms   | 7ms   | 5ms   | 6ms          |
| 32      | 10ms  | 16ms  | 14ms  | 13ms         |
| 64      | 14ms  | 26ms  | 20ms  | 20ms         |
| 128     | 27ms  | 32ms  | 33ms  | 30ms         |
| 256     | 72ms  | 50ms  | 65ms  | 62ms         |
| 512     | 157ms | 216ms | 172ms | 181ms        |

## N = 10000

| Threads | Run 1 | Run 2 | Run 3 | Average Time |
|---------|-------|-------|-------|--------------|
| 1       | 10ms  | 2ms   | 2ms   | 4ms          |
| 2       | 1ms   | 1ms   | 1ms   | 1ms          |
| 4       | 2ms   | 2ms   | 1ms   | 1ms          |
| 8       | 6ms   | 5ms   | 8ms   | 6ms          |
| 16      | 7ms   | 15ms  | 5ms   | 9ms          |
| 32      | 10ms  | 8ms   | 12ms  | 10ms         |
| 64      | 18ms  | 27ms  | 22ms  | 22ms         |
| 128     | 27ms  | 20ms  | 47ms  | 31ms         |
| 256     | 84ms  | 69ms  | 68ms  | 73ms         |
| 512     | 153ms | 162ms | 166ms | 160ms        |

## N = 100000

| Threads | Run 1 | Run 2 | Run 3 | Average Time |
|---------|-------|-------|-------|--------------|
| 1       | 25ms  | 18ms  | 19ms  | 20ms         |
| 2       | 12ms  | 12ms  | 13ms  | 12ms         |
| 4       | 11ms  | 8ms   | 10ms  | 9ms          |
| 8       | 8ms   | 10ms  | 8ms   | 8ms          |
| 16      | 10ms  | 9ms   | 8ms   | 9ms          |
| 32      | 11ms  | 17ms  | 16ms  | 14ms         |
| 64      | 27ms  | 29ms  | 24ms  | 26ms         |
| 128     | 42ms  | 42ms  | 52ms  | 45ms         |
| 256     | 67ms  | 49ms  | 51ms  | 55ms         |
| 512     | 122ms | 164ms | 140ms | 142ms        |

## N = 1000000

| Threads | Run 1 | Run 2 | Run 3 | Average Time |
|---------|-------|-------|-------|--------------|
| 1       | 457ms | 456ms | 456ms | 456ms        |
| 2       | 301ms | 292ms | 267ms | 286ms        |
| 4       | 186ms | 170ms | 171ms | 175ms        |
| 8       | 168ms | 155ms | 158ms | 160ms        |
| 16      | 138ms | 143ms | 143ms | 141ms        |
| 32      | 144ms | 141ms | 142ms | 142ms        |
| 64      | 147ms | 146ms | 146ms | 146ms        |
| 128     | 162ms | 152ms | 167ms | 160ms        |
| 256     | 180ms | 184ms | 181ms | 181ms        |
| 512     | 225ms | 244ms | 243ms | 237ms        |

## N = 10000000

| Threads | Run 1  | Run 2  | Run 3  | Average Time |
|---------|--------|--------|--------|--------------|
| 1       | 8682ms | 9190ms | 8379ms | 8750ms       |
| 2       | 5643ms | 5615ms | 5507ms | 5588ms       |
| 4       | 3930ms | 3895ms | 3908ms | 3911ms       |
| 8       | 3608ms | 3579ms | 4130ms | 3772ms       |
| 16      | 3610ms | 4002ms | 3961ms | 3857ms       |
| 32      | 3801ms | 3984ms | 3750ms | 3845ms       |
| 64      | 3783ms | 4125ms | 4116ms | 4008ms       |
| 128     | 3573ms | 3658ms | 3539ms | 3590ms       |
| 256     | 3706ms | 3595ms | 3648ms | 3649ms       |
| 512     | 3737ms | 3767ms | 3937ms | 3813ms       |