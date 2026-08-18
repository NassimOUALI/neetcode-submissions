class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        ll = list()
        res = 0
        for x in tokens:
            if x == "+":
                a = ll.pop()
                b = ll.pop()
                ll.append(b + a)
            elif x == "-":
                a = ll.pop()
                b = ll.pop()
                ll.append(b - a)
            elif x == "*":
                a = ll.pop()
                b = ll.pop()
                ll.append(b * a)
            elif x == "/":
                a = ll.pop()
                b = ll.pop()
                ll.append(int(b / a))
            else:
                ll.append(int(x))
        return ll.pop()