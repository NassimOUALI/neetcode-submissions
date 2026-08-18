class MinStack:
    def __init__(self):
        self.l = list()
        self.aux = list()

    def push(self, value: int) -> None:
        self.l.append(value)
        if len(self.aux) == 0:
            self.aux.append(value)
        else:
            self.aux.append(min(self.aux[-1],value))

    def pop(self) -> None:
        self.l.pop()
        self.aux.pop()

    def top(self) -> int:
        return self.l[-1]

    def getMin(self) -> int:
        return self.aux[-1]
        