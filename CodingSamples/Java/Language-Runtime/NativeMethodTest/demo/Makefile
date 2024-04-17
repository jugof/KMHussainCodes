input = $(wildcard *.cpp) $(depend)

JAVA_HOME ?= $(shell readlink -e "$$(dirname "$$(readlink -e "$$(which javac)")")"/..)
CFLAGS  +=  -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/linux" -fPIC
LDFLAGS += -shared -L. -Wl,-rpath,.

all: $(output)
$(output): $(input)
	@$(CXX) $(CFLAGS) $(LDFLAGS) $? -o $@

#make output=lib<name>.so

