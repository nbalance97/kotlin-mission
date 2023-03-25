package com.ladder.domain

class Line(
    from: Position,
    to: Position
) {
    val from: Position
    val to: Position

    fun left() = Line(from.left(), to.left())
    fun right() = Line(from.right(), to.right())

    override fun equals(other: Any?): Boolean {
        if (other !is Line) {
            return false
        }

        return (other.from == from && other.to == to) || (other.from == to && other.to == from)
    }

    override fun toString(): String {
        return "Line(from=$from, to=$to)"
    }

    override fun hashCode(): Int {
        var result = from.hashCode()
        result = 31 * result + to.hashCode()
        return result
    }

    init {
        if (from.col > to.row) {
            this.from = to
            this.to = from
        } else {
            this.from = from
            this.to = to
        }
    }
}
