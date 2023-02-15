f=open("codonToAcid/thing.txt","w")
for i in ["A","U","G","C"]:
    for o in ["A","U","G","C"]:
        for u in ["A","U","G","C"]:
            f.write('"'+i+o+u+'":"",\n')
f.close()