package com.lmax.disruptor;

/**
 * MultiCast a series of items between 1 producer and 3 consumers.
 *
 *           +----+
 *    +----->| C1 |
 *    |      +----+
 *    |
 * +----+    +----+
 * | P1 |--->| C2 |
 * +----+    +----+
 *    |
 *    |      +----+
 *    +----->| C3 |
 *           +----+

 * Queue Based:
 *
 *           +----+    +----+
 *    +----->| Q1 |<---| C1 |
 *    |      +----+    +----+
 *    |
 * +----+    +----+    +----+
 * | P1 |--->| Q2 |<---| C2 |
 * +----+    +----+    +----+
 *    |
 *    |      +----+    +----+
 *    +----->| Q3 |<---| C3 |
 *           +----+    +----+
 *
 * P1 - Producer 1
 * Q1 - Queue 1
 * C1 - Consumer 1
 * Q2 - Queue 2
 * C2 - Consumer 2
 * Q3 - Queue 3
 * C3 - Consumer 3
 *
 * Disruptor:
 *                            watch to prevent wrap
 *             +-----------------------------+---------+---------+
 *             |                             |         |         |
 *             |                             v         v         v
 * +----+    +----+    +----+    +----+    +----+    +----+    +----+
 * | P1 |--->| PB |--->| RB |<---| CB |    | C1 |    | C2 |    | C3 |
 * +----+    +----+    +----+    +----+    +----+    +----+    +----+
 *                                  ^        |          |        |
 *                                  |        |          |        |
 *                                  +--------+----------+--------+
 *                                               waitFor
 *
 * P1 - Producer 1
 * PB - Producer Barrier
 * RB - Ring Buffer
 * CB - Consumer Barrier
 * C1 - Consumer 1
 * C2 - Consumer 2
 * C3 - Consumer 3
 *
 */
public final class MultiCast1P3CPerfTest
{
}