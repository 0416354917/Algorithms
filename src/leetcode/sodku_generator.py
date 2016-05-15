data = ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]

with open('output.txt', 'w') as out:
    out.write('{')

    for line in data[:-1]:
        out.write('{')
        for ch in line[:-1]:
            out.write('\'')
            out.write(ch)
            out.write('\', ')
        out.write('\'')
        out.write(line[-1])
        out.write('\'')
        out.write('},')

    line = data[-1]
    out.write('{')
    for ch in line[:-1]:
        out.write('\'')
        out.write(ch)
        out.write('\', ')
    out.write('\'')
    out.write(line[-1])
    out.write('\'')
    out.write('}')


    out.write('};')